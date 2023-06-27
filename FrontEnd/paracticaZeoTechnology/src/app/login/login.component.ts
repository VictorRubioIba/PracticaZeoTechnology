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

  user:User = new User;
  userExist:boolean=false
  
  userName:string=""
  password:string=""


  public login():void{
    console.log("*********")
    console.log(this.userName)
    this.userService.getLogin(this.userName).subscribe(
      
      userExist => {
        console.log(userExist)
        if(userExist){
          this.router.navigate(['/users'])
          swal.fire(' Usuario Encontrado', `Usuario ${this.userName}  esta en la base de datos`, 'success')
        }else{
          swal.fire(' Usuario No Encontrado', `Usuario ${this.userName}  no esta en la base de datos`, 'success')
        }
      
      })
  }
}

/**
 * 
 * 
 * 
 * cargarCliente():void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.ClienteService.getCliente(id).subscribe((cliente) => this.cliente = cliente)
      }
    })

  }
 */
 /*this.activatedRoute.params.subscribe(
        params=> 
        {
          
           const userName = params['username'];
          console.log(userName)
          if(userName){
            this.userService.getLogin(userName).subscribe((user)=>this.user=user)
          }
          
      }
      )*/