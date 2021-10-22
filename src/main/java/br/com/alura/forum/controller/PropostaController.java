package br.com.alura.forum.controller;


import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropostaController {
    private final Tracer tracer;

    public PropostaController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping("/api/search")
    public String returnSpan(){
        Span serverSpan = tracer.activeSpan();
        serverSpan.setTag("user.email", "luram.archanjo@zup.com.br");
        return "Hello";
    }
}
