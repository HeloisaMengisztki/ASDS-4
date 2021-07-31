<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\ControladorCategorias;
use App\Http\Controllers\ControladorProdutos;

Route::get('/', function () {
    return view('index');
});

Route::resource('produtos', ControladorProdutos::class);
Route::resource('categorias', ControladorCategorias::class);