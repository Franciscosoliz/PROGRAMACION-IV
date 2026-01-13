export type Product = {
  id: string;
  name: string;
  price: number;
  descripcion: string;
  marca: string;
  
};

export const PRODUCTS: Product[] = [
  { id: "p1", name: "Mouse", price: 12, descripcion: "Mensaje", marca: "Lenovo" },
  { id: "p2", name: "Keyboard", price: 25, descripcion: "Mensaje", marca: "Lenovo" },
  { id: "p3", name: "Monitor", price: 180, descripcion: "Mensaje", marca: "Lenovo" },
  { id: "p4", name: "Laptop Stand", price: 30, descripcion: "Mensaje", marca: "Lenovo"},
  { id: "p5", name: "Headset", price: 45, descripcion: "Mensaje", marca: "Lenovo" },
];