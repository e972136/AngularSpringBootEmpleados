import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { environment } from '../../../../environments/environment.development';
import { Observable } from 'rxjs';
import { Empleado } from '../../../Shared/Interfaces/empleado';

@Service()
export class EmpleadoService {
  private http = inject(HttpClient)
  private endPoint = `${environment.apiUrl}/empleado`

  getAll():Observable<Empleado[]>{
    return this.http.get<Empleado[]>(`${this.endPoint}/listado`);
  }

  getById(id:number):Observable<Empleado>{
    return this.http.get<Empleado>('${this.endPoint}/${id}');
  }

  create(request:Empleado):Observable<void>{
    return this.http.post<void>(this.endPoint,request);
  }

  update(request:Empleado):Observable<void>{
    return this.http.put<void>(this.endPoint,request);
  }

  delete(id:number):Observable<void>{
    return this.http.delete<void>('${this.endPoint}/${id}');
  }
}
