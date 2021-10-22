package br.com.alura.forum.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	private final Tracer tracer;

	public HelloController(Tracer tracer) {
		this.tracer = tracer;
	}


	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		Span span = tracer.activeSpan();
		span.setTag("Tipo","Hellow World");
		return "Hello World!";
	}

}
