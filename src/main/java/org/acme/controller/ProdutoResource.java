package org.acme.controller;

import io.swagger.annotations.ApiOperation;
import org.acme.dto.CadastrarProdutoDTO;
import org.acme.entity.Produto;
import org.acme.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna todos os produtos")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
//    })
    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public void adicionarProdutos(CadastrarProdutoDTO cadastrarProdutoDTO) {
        Produto p = new Produto();
        p.nome = cadastrarProdutoDTO.nome;
        p.valor = cadastrarProdutoDTO.valor;
        produtoRepository.save(p);
    }

    @PutMapping("/{id}")
    public void alterarProdutoById(@PathParam("id") Long id,
                                   CadastrarProdutoDTO dto) {
        Optional<Produto> p = produtoRepository.findById(id);
        if (!p.isPresent())
            throw new RuntimeException("Produto não localizado!");

        Produto produto = p.get();
        produto.nome = dto.nome;
        produto.valor = dto.valor;
        produtoRepository.save(produto);

    }

    @DeleteMapping("{/id}")
    public void deletarProdutoById(@PathParam("id") Long id) {
        Optional<Produto> produtoOp = produtoRepository.findById(id);
        produtoOp.ifPresent(produto -> produtoRepository.delete(produto));
    }
}
