import {Component, OnDestroy, OnInit} from "@angular/core";
import {LocalizationService} from "../shared/localization.service";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Component({
    selector: "auth-auction",
    templateUrl: "auth.component.html"
})
export class AuthComponent implements OnInit, OnDestroy{
    usernamePlaceholder: string;
    passwordPlaceholder: string;
    auctionName: string;
    tagline: string;
    signIn: string;
    signUp: string;

    username: string;
    password: string;

    constructor(private localizationService: LocalizationService,
                private authService: AuthService) {
    }

    ngOnInit(): void {
        this.usernamePlaceholder = this.localizationService.usernameLabel;
        this.passwordPlaceholder = this.localizationService.passwordLabel;
        this.signIn = this.localizationService.signIn;
        this.signUp = this.localizationService.signUp;
        this.auctionName = this.localizationService.vagrantionName;
    }

    ngOnDestroy(): void {
    }

    onSignIn(): void {
        let user = {
            username: this.username,
            password: this.password
        };
        this.authService.login(user);
    }
}
