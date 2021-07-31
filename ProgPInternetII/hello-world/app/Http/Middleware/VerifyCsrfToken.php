<?php

namespace App\Http\Middleware;

use Illuminate\Foundation\Http\Middleware\VerifyCsrfToken as Middleware;

class VerifyCsrfToken extends Middleware
{
    /**
     * The URIs that should be excluded from CSRF verification.
     *
     * @var array
     */
    protected $except = [
        'rotas/post',
        'rotas/put',
        'rotas/patch',
        'rotas/delete',
        'rotas/options',
        'att3/produtos',
    ];
}
