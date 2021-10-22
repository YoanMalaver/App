<?php

  //conexion con bases de datos
  $mysqli = new mysqli("localhost", "yoan","123456", "android_mysql");

  if (mysqli_connect_error()) {
    die('Error de Conexión (' . mysqli_connect_errno() . ') '
            . mysqli_connect_error());
  }

  // echo 'Éxito... ' . $mysqli->host_info . "\n";

// $mysqli->close(); cierre de conexion
?>