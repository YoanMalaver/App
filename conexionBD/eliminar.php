<?php

    if($_SERVER["REQUEST_METHOD"]=="POST"){
        require_once 'conexion.php';
        $id=$_POST['id'];
        // peticion
        $query="DELETE FROM usuarios WHERE id ='".$id."'";
        $result = $mysqli->query( $query );
        if($mysqli->affected_rows > 0){
            if($result==true){
                echo "Usuario borrado exitosamente";
            }
        } else {
            echo "No hay registros";
        }
        $mysqli->close();
    }

?>