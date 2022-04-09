package com.oracle.jfr;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jfr")
public class JFRController {
	RandomGenerator random = RandomGenerator.getDefault();
	List<MemoryHog> listOfInts = new ArrayList<>();
	int threadAccumulator = 0;
	long integerAccumulator = 0;
	record MemoryHog(Integer value) {};
	
	
	@GetMapping("/leak-threads")
	public String leakThreads() {
//		MyEvent myEvent = new MyEvent();
//		
//		myEvent.begin();
		for (long newThreads = threadAccumulator + 100; threadAccumulator < newThreads; threadAccumulator++) {

			
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {}
				}
			}, "Dead thread - " + threadAccumulator).start();
			
		}
//		myEvent.assignImportantValue(Long.toString(threadAccumulator));
//		myEvent.commit();
		return "Total %d dead threads".formatted(threadAccumulator);
	}

	@GetMapping("/leak-memory")
	public String leakMemory() {
		MyEvent myEvent = new MyEvent();
		myEvent.begin();
		for (long newInts = integerAccumulator + 1000000; integerAccumulator < newInts; integerAccumulator++) {
			listOfInts.add(new MemoryHog(random.nextInt()));
		}
//		myEvent.assignImpRortantValue(Long.toString(integerAccumulator));
		myEvent.commit();
		return "Total %d unreachable Integers".formatted(integerAccumulator);
	}
}
