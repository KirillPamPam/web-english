import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../auth/auth.service";
import {Router} from "@angular/router";

@Component({
    selector: "main",
    templateUrl: "main-page.component.html"
})
export class MainPageComponent implements OnInit {

    constructor(private auth: AuthService) {
    }

    ngOnInit(): void {
        this.auth.test();
    }

}