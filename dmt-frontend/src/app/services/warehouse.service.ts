import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Warehouse } from '../dto';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {
  private baseUrl = 'http://127.0.0.1:8082/api/warehouses';

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }

  private log(message: string) {
    this.messageService.add(`WarehouseService: ${message}`);
  }

    /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  get(): Observable<Warehouse[]> {
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      });
    return this.http.get<Warehouse[]>(this.baseUrl, {headers: headers})
      .pipe(
        tap(_ => this.log('fetched Warehouses')),
        catchError(this.handleError<Warehouse[]>('get Warehouses', []))
      );
  }  

  getById(id: number): Observable<Warehouse> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Warehouse>(url).pipe(
      tap(_ => this.log(`fetched Warehouse id=${id}`)),
      catchError(this.handleError<Warehouse>(`get Warehouse id=${id}`))
    );
  }
  
  save(warehouse: Warehouse): Observable<Warehouse> {
    return this.http.post<Warehouse>(this.baseUrl, warehouse).pipe(
      tap((newWarehouse: Warehouse) => this.log(`added warehouse w/ id=${newWarehouse.id}`)),
      catchError(this.handleError<Warehouse>(`addWarehouse`))
    );
  }

  delete(id: number): Observable<Warehouse> {
    return this.http.delete<Warehouse>(this.baseUrl + '/' + id).pipe(
      tap(_ => this.log(`deleted warehouse id=${id}`)),
      catchError(this.handleError<Warehouse>('deleteWarehouse'))
    );
  }

  update(warehouse: Warehouse): Observable<Warehouse> {
    return this.http.put<Warehouse>(this.baseUrl + '/' + warehouse.id, warehouse).pipe(
      tap((newWarehouse: Warehouse) => this.log(`updated warehouse w/ id=${newWarehouse.id}`)),
      catchError(this.handleError<Warehouse>(`updateWarehouse`))
    );
  }
}
