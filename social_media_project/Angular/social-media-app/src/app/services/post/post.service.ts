import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/post';
import { IUser } from 'src/app/models/user';

@Injectable()
export class PostService {
  private serveUrl: string =  `http://localhost:9005/socialMediaWebApp/api/`;

  constructor(private httpCli:HttpClient) {}

  // post request to /createPost
  addPost(newPost: Post){
    return this.httpCli.post<Post>(this.serveUrl + `post/createPost`, newPost, {withCredentials: true});
  }

  // get request to userPosts
  getPost(userId: number): Observable<Post>{
    return this.httpCli.get<Post>(this.serveUrl + `post/userPosts/${userId}`, {withCredentials: true});
  }

  // post request to allPosts
  getAllPost():Observable<Post> {
    return this.httpCli.post<Post>(this.serveUrl + `post/allPosts`, {withCredentials: true});
  }

  // post request to likePost
  likedPost(updatePost: Post){
    // console.log("Post: "+ JSON.stringify(updatePost));
    return this.httpCli.post(this.serveUrl + `post/likePost`, updatePost, {withCredentials:true});
  }
  
}
