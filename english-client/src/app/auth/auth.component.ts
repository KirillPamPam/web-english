import {Component, Injector, OnDestroy, OnInit} from "@angular/core";
import {LocalizationService} from "../shared/localization.service";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {Store} from "@ngrx/store";
import {Subject} from "rxjs/Subject";
import "rxjs/add/operator/takeUntil";
import {Router} from "@angular/router";
import {Message} from "primeng/primeng";

@Component({
    selector: "auth-auction",
    templateUrl: "auth.component.html"
})
export class AuthComponent implements OnInit, OnDestroy{
    usernamePlaceholder: string;
    passwordPlaceholder: string;
    auctionName: string;
    signIn: string;
    signUp: string;
    visibleError: boolean;
    errorMessage: string;
    paddingLeft: string;

    username: string;
    password: string;

    private unsub: Subject<any> = new Subject();

    constructor(private localizationService: LocalizationService,
                private authService: AuthService,
                private store: Store<any>,
                private route: Router) {
    }

    ngOnInit(): void {
        if (this.route.url.endsWith("error")) {
            this.errorMessage = this.localizationService.accessDenied;
            this.visibleError = true;
            this.paddingLeft = "31%;"
        }

        this.usernamePlaceholder = this.localizationService.usernameLabel;
        this.passwordPlaceholder = this.localizationService.passwordLabel;
        this.signIn = this.localizationService.signIn;
        this.signUp = this.localizationService.signUp;
        this.auctionName = this.localizationService.vagrantionName;

        this.store.select("failLogin")
            .takeUntil(this.unsub)
            .subscribe(state => {
                if (state) {
                    this.visibleError = state.fail;
                    this.errorMessage = state.message;
                }
            })
    }

    ngOnDestroy(): void {
        this.unsub.next();
        this.unsub.complete();
    }

    onSignIn(): void {
        let user = {
            userName: this.username,
            password: this.password
        };
        this.authService.login(user);
    }

    onLogout(): void {
    //    this.visibleError = !this.visibleError;
    }
}
