package com.ananyo.razorpay.merchant.repository;

import com.ananyo.razorpay.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
