insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Aceite', 'El mejor aceite', 'AgroUja', 'aceite.png', 'Nuevo', 'Comestible', 'Venta', true, 10.4);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Pala', 'La mejor pala', 'AgroUja', 'pala.png', 'Nuevo', 'Maquinaria', 'Venta', true, 5.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Tractor', 'El mejor tractor', 'AgroUja', 'tractor.png', 'Nuevo', 'Maquinaria', 'Venta', true, 50000.7); 
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Malla Agrícola', 'La mejor malla agrícola', 'AgroUja', 'malla.jpg', 'Nuevo', 'Maquinaria', 'Venta', true, 5000.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Excavadora', 'La mejor excavadora', 'AgroUja', 'excavadora.png', 'Nuevo', 'Maquinaria', 'Venta', true, 50000.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Motosierra', 'La mejor motosierra', 'AgroUja', 'motosierra.png', 'Nuevo', 'Maquinaria', 'Venta', true, 250.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Azada', 'La mejor azada', 'AgroUja', 'azada.png', 'Nuevo', 'Maquinaria', 'Venta', true, 50.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Mejor aceite', 'El mejor aceite del mundo', 'AgroUja', 'mejoraceite.jpg', 'Nuevo', 'Comestible', 'Venta', true, 50.7);

insert into Formulario (email, nombre, telefono, pais, asunto, mensaje) values ('Trolololo@yopmail.com', 'Trol', '123456789', 'Alemania', 'Tractor roto', 'Tractor no furula');

insert into Usuario (Nombre, Apellidos) values ('Roberto', 'Antonio');

UPDATE producto SET idUsuario = 'pcc00031' WHERE marca = 'AgroUja';