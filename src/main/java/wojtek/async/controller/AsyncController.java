package wojtek.async.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wojtek.async.service.AsyncService;

@RestController
public class AsyncController {

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/async", method = RequestMethod.GET)
	public void testAsynch() throws InterruptedException, ExecutionException 
	{
		System.out.println("WEB  Start");

		List<Future<String>> lista = new ArrayList<>();
		Future<String> f;

		for (int watek=0 ; watek < 30;  watek ++){
			f = service.getTask();
			lista.add(f);
		}

		System.out.println("czekamy  na watki ..." );

		for ( Future<String> watek : lista){
			while(!watek.isDone()) {
				System.out.println(watek.get());
			}
		}

		System.out.println("WEB  END");
	}
}
