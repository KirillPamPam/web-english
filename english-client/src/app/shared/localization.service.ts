import {Injectable} from "@angular/core";

export abstract class LocalizationService {
    usernameLabel: string;
    passwordLabel: string;
    signIn: string;
    signUp: string;

    vagrantionName: string;
}

@Injectable()
export class EngLocalizationService extends LocalizationService {
    constructor() {
        super();
        this.usernameLabel = "Username";
        this.passwordLabel = "Password";
        this.signUp = "Sign Up";
        this.signIn = "Sign In";
        this.vagrantionName = "Web-English";
    }
}