package tda.darkarmy.ngomanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donationId;
	private String courierTrackingId;
	private String donationType;
	private Long donationAmount;
	private String donatedClothesDescription;
	private String medicineName;
	private String usedFor;
	private String expiryDate;

	@ManyToOne
	private User user;
}
