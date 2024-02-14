package com.example.Project.DAO;
import com.example.Project.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignDAO  extends JpaRepository<Campaign, Long> {
}
