package in.sp.main.Service;

import java.util.List;

import in.sp.main.entity.Contest;

public interface ContestService 
{
   public Contest createContest(Contest cnt);
   public 	List<Contest> getAllContests();
   public Contest getContestById(int  id);
   public Contest UpdateContest(int id, int score);
   public String DeleteContest(int id);


}
