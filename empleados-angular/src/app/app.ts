import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CrearEmpleadoPage } from './Features/Empleado/Pages/crear-empleado-page/crear-empleado-page';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CrearEmpleadoPage],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('empleados-angular');
}
