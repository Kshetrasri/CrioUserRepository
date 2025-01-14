package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Service.ContestService;
import in.sp.main.entity.Contest;


@RestController
public class MyController 
{
	@Autowired
	private  ContestService cntService;
	
	@PostMapping("/contest")
	public Contest RegisterContest(@RequestBody Contest contest)
	{
		return cntService.createContest(contest);
	}
	
	@GetMapping("/contest/{id}")
	public Contest getDetails(@PathVariable int id)
	{
		return cntService.getContestById(id);
	}
	
	@GetMapping("/contest")
	public List<Contest> getAllDetails()
	{
		return cntService.getAllContests();
	}
	
	 
	
	@PutMapping("/contest/{id}/{score}")
	public ResponseEntity<Contest> updateScore(
	        @PathVariable("id") int userId,
	        @PathVariable("score") int score)
	{
	    if (score < 0 || score > 100) {
	        return ResponseEntity.badRequest().body(null); // Invalid score check
	    }
	    // Assuming cntService.UpdateContest handles the update logic
	    Contest updatedContest = cntService.UpdateContest(userId, score);
	    if (updatedContest == null) {
	        return ResponseEntity.notFound().build(); // No user with userId = id
	    }
	    return ResponseEntity.ok(updatedContest);
	}
	
//	
//	@DeleteMapping("/cntDelete")
//	public String deleteValue(@RequestBody Contest cnt)
//	{
//		
//		return cntService.DeleteContest(cnt);
//	}
//	
	
	@DeleteMapping("/cntDelete/{id}")
	public String deleteValue(@PathVariable int id, @RequestBody(required = false) Contest cnt)
	{
	    // Use the id to delete the specific record
	    return cntService.DeleteContest(id);
	}

}




//Test cases (JUnit)

//To include basic JUnit test cases, you would typically write a separate test class using Spring Boot Test annotations.
//Here is an example:

/*
@SpringBootTest
public class UserApiApplicationTests {

 @Autowired
 private UserController userController;

 @Test
 void registerUserTest() {
     Map<String, String> request = new HashMap<>();
     request.put("userId", "U123");
     request.put("username", "testuser");

     ResponseEntity<String> response = userController.registerUser(request);
     assertEquals(HttpStatus.CREATED, response.getStatusCode());
 }

 @Test
 void updateScoreTest() {
     Map<String, String> registerRequest = new HashMap<>();
     registerRequest.put("userId", "U123");
     registerRequest.put("username", "testuser");
     userController.registerUser(registerRequest);

     Map<String, Integer> updateRequest = new HashMap<>();
     updateRequest.put("score", 50);
     ResponseEntity<String> response = userController.updateScore("U123", updateRequest);
     assertEquals(HttpStatus.OK, response.getStatusCode());
 }

 @Test
 void retrieveUsersTest() {
     // Add multiple users and verify sorting
 }
}
*/

