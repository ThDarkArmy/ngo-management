package tda.darkarmy.ngomanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Happenings
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long happeningsId;
	private String happeningsTitle;
	@Lob
	@Column(length=5120)
	private String happeningsDescription;
	private String happeningDate;
	private String place;
}
