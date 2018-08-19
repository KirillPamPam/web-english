import {NgModule} from "@angular/core";
import {AuthComponent} from "./auth.component";
import {ButtonModule, InputTextModule, MessageModule, MessagesModule, PasswordModule} from "primeng/primeng";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

@NgModule({
    imports: [
        FormsModule,
        InputTextModule,
        PasswordModule,
        ButtonModule,
        HttpClientModule,
        ButtonModule,
        BrowserModule,
        BrowserAnimationsModule,
        MessageModule,
        MessagesModule
    ],
    exports: [

    ],
    declarations: [
        AuthComponent
    ]
})
export class AuthModule {
}
