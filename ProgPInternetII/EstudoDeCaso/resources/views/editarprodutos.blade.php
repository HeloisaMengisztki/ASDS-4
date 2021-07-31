@extends('layout.app', ["current" => "produto"])
@section('body')

<div class="card border">
    <div class="card-body">
        <form action="{{ route('produtos.update', $prod->id) }}" method="POST">
            @csrf
            @method('PUT')
            <div class="row">
                <div class="form-group col-3">
                    <label for="nomeProduto">Nome do Produto</label>
                    <input type="text" required class="form-control" name="nomeProduto" value="{{$prod->nome}}"
                    id="nomeProduto" placeholder="Produto">
                </div>
                <div class="form-group col-3">
                    <label for="estoque">Estoque</label>
                    <input type="number" required min="0" value="{{$prod->estoque}}" class="form-control" name="estoque"
                    id="estoque">
                </div>
                <div class="form-group col-3">
                    <label for="preco">Preço</label>
                    <input type="number" required min="0" value="{{$prod->preco}}" step=".01" class="form-control" name="preco"
                    id="preco" placeholder="Produto">
                </div>
                <div class="form-group col-3">
                    <label for="categoriaId">Categoria</label>
                    <select class="form-control" name="categoriaId" aria-label=".form-select-lg example">
                    @foreach($cats as $cat)
                    <option class="form-control" name="categoriaId" value="{{$cat->id}}" id="categoriaId">{{$cat->id}} - {{$cat->nome}}</option>
                    @endforeach
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
            <button type="cancel" class="btn btn-danger btn-sm">Cancelar</button>
        </form>
    </div>
</div>
@endsection