package com.accessphone.productos.controller;

import com.accessphone.productos.model.Producto;
import com.accessphone.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permitir acceso desde cualquier cliente
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // Crear un producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener un solo producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoRepository.findById(id);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto datosNuevos) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        producto.setNombre(datosNuevos.getNombre());
        producto.setPrecio(datosNuevos.getPrecio());
        producto.setCantidad(datosNuevos.getCantidad());
        return productoRepository.save(producto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}
