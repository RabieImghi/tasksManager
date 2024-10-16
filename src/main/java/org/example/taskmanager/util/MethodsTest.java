package org.example.taskmanager.util;

public interface MethodsTest {
    void testRegisterUserSuccess();
  //  void testRegisterUserThrowsExceptionWhenUserIsNull() ;
   // void testRegisterUserThrowsExceptionWhenUsernameExists() ;

    void testLoginSuccess() ;
    //void testLoginThrowsExceptionWhenPasswordIsInvalid() ;
    void testLoginReturnsEmptyWhenUsernameNotFound() ;

    void testGetByIdSuccess() ;
    void testGetByIdReturnsEmptyWhenUserNotFound() ;

    void testFindByUsernameSuccess() ;
        void testFindByUsernameReturnsEmptyWhenUserNotFound() ;

    void testDeleteByIdSuccess() ;
    void testDeleteByIdThrowsExceptionWhenUserIsNull() ;
    //void testDeleteByIdThrowsExceptionWhenUserNotFound() ;

    void testUpdateUserSuccess() ;
    void testUpdateUserThrowsExceptionWhenUserIsNull() ;

    void testGetAllUsersSuccess() ;

}