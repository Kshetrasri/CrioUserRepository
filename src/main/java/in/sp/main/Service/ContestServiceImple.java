package in.sp.main.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import in.sp.main.Repository.ContestRepository;
import in.sp.main.entity.Contest;


@Service
public class ContestServiceImple implements ContestService
{
	@Autowired
	private ContestRepository cntRepository;
	


	@Override
	public Contest createContest(Contest cnt) {
		// TODO Auto-generated method stub
		return cntRepository.save(cnt);
	}

	
	@Override
	public List<Contest> getAllContests()
	{
//		return cntRepository.findAll();
		 return cntRepository.findAll(Sort.by(Sort.Direction.ASC, "score"));
		
	}
	
	


	@Override
	public Contest getContestById(int  id) 
	{
		return cntRepository.findById(id);
	}


	@Override
	public Contest UpdateContest(int id, int score)
	{
		if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
		 System.out.println("Updating Contest in Score: " + score+ " with id: " + id);
        Contest contest = cntRepository.findById(id);

        // Update the score
        contest.setScore(score);

        // Update badges based on score
        List<String> badges = new ArrayList<>();
        if (score >= 1 && score < 30) {
            badges.add("Code Ninja");
        }
        if (score >= 30 && score < 60) {
            badges.add("Code Champ");
        }
        if (score >= 60) {
            badges.add("Code Master");
        }
        contest.setBadges(badges);
        return cntRepository.save(contest);
       
    
	}


	@Override
	public String DeleteContest(int id) {
	    try {
	        if (cntRepository.existsById(id)) {
	            cntRepository.deleteById(id);
	            return "Contest with ID " + id + " deleted successfully.";
	        } else {
	            return "Contest with ID " + id + " not found.";
	        }
	    } catch (Exception e) {
	        return "An error occurred while trying to delete Contest with ID " + id + ": " + e.getMessage();
	    }
	}


	


	




	
}
