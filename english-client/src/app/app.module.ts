import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {RouterModule} from "@angular/router";
import {AuthModule} from "./auth/auth.module";
import {appRoutes} from "./routers";
import {Providers} from "./providers.index";
import {StoreModule} from "@ngrx/store";
import {Reducers} from "./shared/reducers";
import {MainPageModule} from "./components/main-page/main-page.module";

@NgModule({
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes, {useHash: true}),
        StoreModule.forRoot(Reducers),
        AuthModule,
        MainPageModule
    ],
    declarations: [
        AppComponent
    ],
    providers: [
        Providers
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {}