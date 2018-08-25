package wojtek.async.service;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsyncService {

static int i=0;

	@Async("asyncWojtek")
	public Future<String> getTask() throws InterruptedException
	{
		i++;
		System.out.println("async watek numer " + i +" start == " + Thread.currentThread());
		LocalTime t = LocalTime.now();
		System.out.println("start time : " + t);

		Thread.sleep(6000L);

		LocalTime t1 = LocalTime.now();
		return new AsyncResult<String>("async watek " + i + " completed nazwa:" + Thread.currentThread() +"  ++ end time : " + t1 );
	}



}
