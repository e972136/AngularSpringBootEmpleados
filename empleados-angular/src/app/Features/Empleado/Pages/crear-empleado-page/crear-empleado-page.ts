import { Component, inject, OnInit, signal } from '@angular/core';
import { PosicionService } from '../../../Posicion/Service/posicion-service';
import { EmpleadoService } from '../../Service/empleado-service';
import { EmpleadoModel } from '../../Models/empleado-model';
import { Posicion } from '../../../../Shared/Interfaces/posicion';
import { form, required, validate } from '@angular/forms/signals';

@Component({
  selector: 'app-crear-empleado-page',
  imports: [],
  templateUrl: './crear-empleado-page.html',
  styleUrl: './crear-empleado-page.css',
})
export class CrearEmpleadoPage implements OnInit {

  private positionService = inject(PosicionService)
  private empleadoService = inject(EmpleadoService)

  posiciones = signal<Posicion[]>([]);

  empleadoModel = signal<EmpleadoModel>({
          id:"0",
         nombre:"",
         correo:"",
         fechaNacimiento:"",
         posicionId:"0"
  });

  

  empleadoForm = form(this.empleadoModel,(schemaPath)=>{
    required(schemaPath.nombre,{message:"patito"});
    required(schemaPath.correo,{message:"patito"});
    required(schemaPath.fechaNacimiento,{message:"patito"});
    validate(schemaPath.posicionId,({value})=>{
      if(value().match("0")) 
          return {kind:"equals",message:"error posicion"};
          return null;        
    })
  });

  ngOnInit(): void {
    this.positionService.getAll().subscribe({
        next: response=>{
          console.log(response)
          this.posiciones.set(response)
        },
        error:(e) => {console.log(e.error)}
    })
  }
}
