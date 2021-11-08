import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/post';
import { IUser } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class SearchUserService {
  private url:string  = "http://localhost:9005/socialMediaWebApp/api/userAccount/";
  constructor(private httpCli:HttpClient) { }

  // get request to userAccount
  getUserByName(username: string): Observable<IUser>{
    return this.httpCli.get<IUser>(this.url + `getUserByUsername/${username}`, {withCredentials: true});
  }
}
