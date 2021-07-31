<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class AlunosController extends Controller
{
    private $alunos = [];
    
    public function __construct(){
        $alunos = session('alunos');
        if(!isset($alunos)){
            session(['alunos'=>$this->alunos]);
        }
    }

    private function getIndex($id, $alunos){
        $ids = array_column($alunos, 'id');
        $index = array_search($id, $ids);
        return $index;
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $alunos = session('alunos');
        return view('alunos-index', compact(['alunos']));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('cadastro-aluno');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $alunos = session('alunos');

        $id = end($alunos)['id']+1;
        $nome = $request->nome;
        $dados = ["id"=>$id, "nome"=>$nome];

        $alunos[] = $dados;

        session(['alunos'=>$alunos]);
        return redirect()->route('alunos.index');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $alunos = session('alunos');
        $index = self::getIndex($id, $alunos);
        $aluno = $alunos[$index];

        return view('aluno-info', compact(['aluno']));
    }
    
    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $alunos = session('alunos');
        $index = self::getIndex($id, $alunos);
        $aluno = $alunos[$index];

        return view('aluno-edit', compact(['aluno']));
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
        $alunos = session('alunos');

        $index = self::getIndex($id, $alunos);
        $alunos[$index]['nome'] = $request->nome;
        
        session(['alunos'=>$alunos]);
        return redirect()->route('alunos.index');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $alunos = session('alunos');
        $index = self::getIndex($id, $alunos);

        array_splice($alunos, $index, 1);

        session(['alunos'=>$alunos]);
            return redirect()->route('alunos.index');
    }
}
