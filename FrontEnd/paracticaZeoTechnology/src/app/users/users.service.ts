import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class userService {
  
private urlEndPoint:string ='http://localhost:8080/front/users'
private urlEndPointLogin:string ='http://localhost:8080/front/login'


  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.urlEndPoint);
  }

  create(user: User):Observable<User>{
    return this.http.post<User>(this.urlEndPoint,user)
  }

  getLogin(user:User): Observable<any>{
    return this.http.post<any>(this.urlEndPointLogin,user)
    
  }

}