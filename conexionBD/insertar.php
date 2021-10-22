<?php
    if($_SERVER["REQUEST_METHOD"]=="POST"){
        //llamada a base de datos
        require_once 'conexion.php';
        $nombre=$_POST["nombre"];
        $email=$_POST["email"];
        $telefono=$_POST["telefono"];
        $password=$_POST["password"];

        //query que inserta datos
        $query="INSERT INTO usuarios (nombre, email, telefono, password)
                              VALUES ('".$nombre."','".$email."','".$telefono."','".$password."')";
        $result = $mysqli->query( $query );
        if($result==true) {
            echo "El usuario se inserto exitosamente";
        } else {
            echo "Error al insertar el usuario";
        }

    }
?>