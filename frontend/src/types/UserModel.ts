import { TaskModel } from "./TaskModel";

export interface UserModel {
    "id":number,
    "username": string,
    "tasks":TaskModel[] 
}