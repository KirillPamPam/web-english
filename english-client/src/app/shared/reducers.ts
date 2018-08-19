import {Action} from "@ngrx/store";

export function failLoginReducer(state: any = null, action: ActionReducer) {
    switch (action.type) {
        case "AUTH_LOGIN":
            return action.payload;
        default:
            return state;
    }
}

export const Reducers: any = {
    failLogin: failLoginReducer
};

export interface ActionReducer extends Action {
    payload?: any;
}