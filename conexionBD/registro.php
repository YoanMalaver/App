<?php

    if($_SERVER["REQUEST_METHOD"]=="GET"){
        require_once 'conexion.php';
        $id=$_GET['id'];
        // peticion
        $query="SELECT * FROM usuarios WHERE id ='".$id."'";
        $result = $mysqli->query( $query );
        if($mysqli->affected_rows > 0){
            while($row=$result->fetch_assoc()){
                $array=$row;
            }
            // convertir arreglo en json
            echo json_encode($array);
        } else {
            echo "No hay registros";
        }
        $result->close();
        $mysqli->close();
    }

?>