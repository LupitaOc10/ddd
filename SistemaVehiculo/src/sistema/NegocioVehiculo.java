package sistema;

public class NegocioVehiculo {
String VehiculoId;
String Marca;
String Modelo;
String Año;
String Color;
String Tipo;
DataVehiculo dp=null;

public NegocioVehiculo() {
dp=new DataVehiculo();
}
public boolean Insertar() {
return (dp.Insertar(this))?true:false;
}
public boolean Cargar() {
return (dp.Cargar(this))?true:false;
}
public String getVehiculoId() {
return VehiculoId;
}
public void setVehiculoId(String vehiculoId) {
VehiculoId = vehiculoId;
}
public String getMarca() {
return Marca;
}
public void setMarca(String marca) {
Marca = marca;
}
public String getModelo() {
return Modelo;
}
public void setModelo(String modelo) {
Modelo = modelo;
}
public String getAño() {
return Año;
}
public void setAño(String año) {
Año = año;
}
public String getColor() {
return Color;
}
public void setColor(String color) {
Color = color;
}
public String getTipo() {
return Tipo;
}
public void setTipo(String tipo) {
Tipo = tipo;
}


public boolean Actualizar() {
return (dp.Actualizar(this))?true:false;
}

}
