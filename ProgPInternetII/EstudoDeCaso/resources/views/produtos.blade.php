@extends('layout.app', ["current" => "produto"])

@section('body')
<div class="card border">
<div class="card-body">
<h5 class="card-title">Cadastro de Produtos</h5>

<div class="card-footer">
<a href="produtos/create" class="btn btn-sm btn-primary" role="button">Novo Produto</a>
</div>


@if(count($prods) > 0)
<table class="table table-ordered table-hover">
<thead>
<tr>
<th>Código</th>
<th>Nome do Produto</th>
<th>Estoque</th>
<th>Preço</th>
<th>Categoria</th>
<th>Ações</th>
</tr>
</thead>
<tbody>
@foreach($prods as $prod)
<tr>
<td>{{$prod->id}}</td>
<td>{{$prod->nome}}</td>
<td>{{$prod->estoque}}</td>
<td>{{$prod->preco}}</td>
<td>{{$prod->nome_categoria}}</td>

<td class="row">
    <div class="col-3 m-0 p-0">
        <form action="{{ route('produtos.edit', $prod->id) }}" method="POST">
        @csrf
        @method('GET')
        <input type="submit" class="btn btn-sm btn-primary" value="Editar">
        </form>
    </div>
    <div class="col m-0 p-0">
        <form action="{{ route('produtos.destroy', $prod->id) }}" method="POST">
        @csrf
        @method('DELETE')
        <input type="submit" class="btn btn-sm btn-danger" value="Apagar">
        </form>
    </div>
</td>

</tr>
@endforeach
</tbody>
</table>
@endif

@endsection