import {Routes} from "@angular/router";
import {AuthComponent} from "./auth/auth.component";
import {MainPageComponent} from "./components/main-page/main-page.component";

export const appRoutes: Routes = [
    {path: "", redirectTo: "/auth", pathMatch: "full"},
    {path: "auth", component: AuthComponent},
    {path: "auth/error", component: AuthComponent},
    {path: "main", component: MainPageComponent}
];