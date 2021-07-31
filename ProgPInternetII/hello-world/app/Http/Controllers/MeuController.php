<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class MeuController extends Controller
{
    public function produtos(Request $request){
        echo "<h3>Produtos</h3>";
        echo "<ol>";
        echo "<li>Notebook</li>";
        echo "<li>Impressora</li>";
        echo "<li>Mouse</li>";
        echo "</ol>";
    }

    public function getIdade(){
        echo "idadeBoa";
    }

    public function getNome(){
        echo "nome completo";
    }

    public function getSoma($valor1, $valor2){
        $resultado = $valor1+$valor2;
        echo $resultado;
    }

    public function getSubtrai($valor1, $valor2){
        $resultado = $valor1-$valor2;
        echo $resultado;
    }

    public function getMultiplica($valor1, $valor2){
        $resultado = $valor1*$valor2;
        echo $resultado;
    }

    public function getDivide($valor1, $valor2){
        $resultado = $valor1/$valor2;
        echo $resultado;
    }

    public function calcular(Request $request){
        $valor1 = (int) $request->input('valor1');
        $valor2 = (int) $request->input('valor2');

        if((int)$valor2 == 0){
            $div = '--';
        }else{
            $div =  $valor1/$valor2;
        }

        $soma = $valor1+$valor2;
        $sub =  $valor1-$valor2;
        $mult = $valor1*$valor2;

        return view('calc', ['soma'=>$soma, 'sub'=>$sub, 'mult'=>$mult, 'div'=>$div]);
    }
}
