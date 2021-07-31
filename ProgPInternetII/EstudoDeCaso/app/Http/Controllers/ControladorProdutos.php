<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

use App\Models\Produto;
use App\Models\Categoria;

class ControladorProdutos extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        // $prods = Produto::all();

        $prods = DB::table('produtos')
        ->join('categorias', 'produtos.categoria_id', '=', 'categorias.id')
        ->select('produtos.*', 'categorias.nome as nome_categoria')
        ->get();

        return view('produtos', compact('prods'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $cats = Categoria::all();
        return view('novoproduto', compact('cats'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $prod = new Produto();
        $prod->nome = $request->input('nomeProduto');
        $prod->estoque = $request->input('estoque');;
        $prod->preco = $request->input('preco');
        $prod->categoria_id = $request->input('categoriaId');

        $prod->save();

        return redirect('/produtos');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        // $prod = Produto::find($id);

        $prod = DB::table('produtos')
        ->join('categorias', 'produtos.categoria_id', '=', 'categorias.id')
        ->select('produtos.*', 'categorias.nome as nome_categoria')
        ->where('produtos.id', '=', $id)
        ->first();

        if(isset($prod)){
            $cats = Categoria::all();
            return view('editarprodutos', compact('prod'), compact('cats'));
        }

        return redirect('/produtos');
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $prod = Produto::find($id);

        if(isset($prod)){
            $prod->nome = $request->input('nomeProduto');
            $prod->estoque = $request->input('estoque');;
            $prod->preco = $request->input('preco');
            $prod->categoria_id = $request->input('categoriaId');
            $prod->save();
        }

        return redirect('/produtos');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $prod = Produto::find($id);

        if(isset($prod)){
            $prod->delete();
        }

        return redirect('/produtos');
    }
}
