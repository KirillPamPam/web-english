import {NgModule} from "@angular/core";
import {ButtonModule, InputTextModule, MessageModule, MessagesModule, PasswordModule} from "primeng/primeng";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {MainPageComponent} from "./main-page.component";

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
        MainPageComponent
    ]
})
export class MainPageModule {
}
