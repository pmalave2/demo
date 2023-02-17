export interface Rack {
  id?: number;
  uuid: string;
  type?: string;
  warehouseId: number;
}

export namespace Rack{
  export enum Type {
    A, B, C, D
  }
}