import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { environment } from '../../../../environments/environment.development';
import { Posicion } from '../../../Shared/Interfaces/posicion';
import { Observable } from 'rxjs';

@Service()
export class PosicionService {
      private http = inject(HttpClient)
  private endPoint = `${environment.apiUrl}/posicion`

    getAll():Observable<Posicion[]>{
      return this.http.get<Posicion[]>(`${this.endPoint}/listado`);
    }
}
