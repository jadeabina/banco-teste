package br.com.banco.controller;
//buscar e salvar usuario

import br.com.banco.models.Empresa;
import br.com.banco.models.Usuario;
import br.com.banco.persitence.EmpresaRepository;
import br.com.banco.persitence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    private final EmpresaRepository empresaRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    @PostMapping("/salvar")
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        Empresa empresa = empresaRepository.findById(usuario.getEmpresa().getId()).get();
        usuario.setEmpresa(empresa);
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/buscarTodos")
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/buscarPorId/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }


}