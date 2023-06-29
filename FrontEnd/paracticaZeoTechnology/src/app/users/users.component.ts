import { Component } from '@angular/core';
import { User } from './user';
import { userService } from './users.service';
import swal from "sweetalert2";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  users: User[]=[]

  constructor(private userService: userService){}
  ngOnInit(): void {
    this.userService.getUsers().subscribe(
    users => {this.users = users}
    );
  }
}

