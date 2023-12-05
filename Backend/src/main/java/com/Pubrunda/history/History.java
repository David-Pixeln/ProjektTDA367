package com.Pubrunda.history;

import com.Pubrunda.completedPubCrawl.CompletedPubCrawl;
import com.Pubrunda.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @NonNull
    @OneToMany
    @JoinColumn(name = "completed_pub_crawl_id")
    private List<CompletedPubCrawl> completedPubCrawlList;
}
