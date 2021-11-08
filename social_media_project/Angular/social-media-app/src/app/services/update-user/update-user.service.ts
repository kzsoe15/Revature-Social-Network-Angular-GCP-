import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from 'src/app/models/user';

@Injectable()
export class UpdateUserService {

  private url:string  = "http://localhost:9005/socialMediaWebApp/api/userAccount/updateProfile/";

  constructor(private httpCli:HttpClient) { }
  
  //post request to updateProfile
  update(editUser: IUser) {
    // console.log("Update!!! "+ JSON.stringify(editUser));
    return this.httpCli.post(this.url, editUser, {withCredentials: true, responseType:"text",observe:"response"});
  }
}
