import { User } from './../users/user';
import { Component, OnInit } from '@angular/core';
import { userService } from '../users/users.service';
import { ActivatedRoute, Router } from '@angular/router';
import swal  from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'

})
export class LoginComponent implements OnInit{

  ngOnInit(): void {
  //this.login();
  }

  public titulo:string = "Login"
  constructor(private userService: userService,private router:Router, private activatedRoute:ActivatedRoute){}

  public user:User = new User();
  
  
  
  userExist:boolean=false
  




  public login():void{
    console.log("*********")
    console.log(this.user.name)
    this.userService.getLogin(this.user).subscribe(
      
      userExist => {
        console.log(userExist)
        if(userExist){
          this.router.navigate(['/users'])
          swal.fire(' Usuario Encontrado', `Usuario ${this.user.name}  esta en la base de datos`, 'success')
        }else{
          //swal.fire(' Usuario No Encontrado', `Usuario ${this.user.name}  no esta en la base de datos`, 'success')
         swal.fire({
      title: 'Usuario no encontrado',
      text: `El usuario o la contraseña son incorrectos`,
      icon: 'warning',
    
    })
        }
      
      })
  }
}

